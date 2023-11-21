import { memo, SVGProps } from 'react';

const TimeLeftAreaIcon = (props: SVGProps<SVGSVGElement>) => (
  <svg preserveAspectRatio='none' viewBox='0 0 419 135' fill='none' xmlns='http://www.w3.org/2000/svg' {...props}>
    <path
      d='M27.7421 9.99999C27.7421 4.47715 32.2192 0 37.7421 0H409C414.523 0 419 4.47715 419 10V96.6667C419 102.19 414.523 106.667 409 106.667H37.7421C32.2192 106.667 27.7421 102.19 27.7421 96.6667V9.99999Z'
      fill='#BB66FF'
    />
    <g filter='url(#filter0_f_749_6076)'>
      <path
        d='M0 38.3332C0 32.8104 4.47715 28.3333 10 28.3333H381.258C386.781 28.3333 391.258 32.8104 391.258 38.3333V125C391.258 130.523 386.781 135 381.258 135H10C4.47716 135 0 130.523 0 125V38.3332Z'
        fill='white'
      />
    </g>
    <defs>
      <filter
        id='filter0_f_749_6076'
        x={-4}
        y={24.3333}
        width={399.258}
        height={114.667}
        filterUnits='userSpaceOnUse'
        colorInterpolationFilters='sRGB'
      >
        <feFlood floodOpacity={0} result='BackgroundImageFix' />
        <feBlend mode='normal' in='SourceGraphic' in2='BackgroundImageFix' result='shape' />
        <feGaussianBlur stdDeviation={2} result='effect1_foregroundBlur_749_6076' />
      </filter>
    </defs>
  </svg>
);

const Memo = memo(TimeLeftAreaIcon);
export { Memo as TimeLeftAreaIcon };
